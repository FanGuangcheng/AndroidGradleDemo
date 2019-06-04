package com.addtimestamp;

import java.util.List;
import java.util.Map;

public class AddTimeStampExtension {

    public Map<String, List<String>> hookPoint;
    public Map<String, String> timeStampPrinter;

    @Override
    public String toString() {
        return "addTimeStamp { hookPoint = " + hookPoint + ", timeStampHandler = " + timeStampPrinter + " }" ;
    }
}
