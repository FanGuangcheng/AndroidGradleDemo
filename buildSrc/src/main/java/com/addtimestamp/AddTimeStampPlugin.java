package com.addtimestamp;

import com.android.build.gradle.AppExtension;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.util.Collections;


public class AddTimeStampPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        AddTimeStampExtension extension = project.getExtensions().create("addTimeStamp", AddTimeStampExtension.class);

        Config.getInstance().extension = extension;

        AppExtension appExtension = (AppExtension) project.getProperties().get("android");
        appExtension.registerTransform(new AddTimeStampTransform(project), Collections.EMPTY_LIST);
    }
}