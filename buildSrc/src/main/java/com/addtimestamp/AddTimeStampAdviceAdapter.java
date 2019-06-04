package com.addtimestamp;


import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.*;

import java.util.Map;

public class AddTimeStampAdviceAdapter extends AdviceAdapter {

    Label l1;
    Label l2;
    private String timeStampHandleClass;
    private String timeStampHandleMethod;
    private String mClassName;
    private String mMethodName;

    /**
     * Creates a new {@link AdviceAdapter}.
     *
     * @param api    the ASM API version implemented by this visitor. Must be one
     *               of {@link Opcodes#ASM4} or {@link Opcodes#ASM5}.
     * @param mv     the method visitor to which this adapter delegates calls.
     * @param access the method's access flags (see {@link Opcodes}).
     * @param name   the method's name.
     * @param desc   the method's descriptor (see {@link Type Type}).
     */
    protected AddTimeStampAdviceAdapter(int api, MethodVisitor mv, int access, String name, String desc, String className) {
        super(api, mv, access, name, desc);
        mClassName = className;
        mMethodName = name;
        Map<String, String> timeStampHandler = Config.getInstance().extension.timeStampPrinter;
        if (timeStampHandler != null && !timeStampHandler.isEmpty()) {
            timeStampHandler.entrySet().forEach(entry -> {
                timeStampHandleClass = entry.getKey().replace(".", "/");
                timeStampHandleMethod = entry.getValue();
            });
        }
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        if (timeStampHandleClass != null && timeStampHandleMethod != null) {
            String start = mClassName + "->" +methodDesc + ": method start ";
            mv.visitLdcInsn(start);
            mv.visitMethodInsn(INVOKESTATIC, timeStampHandleClass,
                    timeStampHandleMethod, "(Ljava/lang/String;)V", false);
        }
    }

    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
        if (timeStampHandleClass != null && timeStampHandleMethod != null) {
            String end = mClassName + "->" +methodDesc + ": method end ";

            mv.visitLdcInsn(end);
            mv.visitMethodInsn(INVOKESTATIC, timeStampHandleClass,
                    timeStampHandleMethod, "(Ljava/lang/String;)V", false);
        }
    }
}
