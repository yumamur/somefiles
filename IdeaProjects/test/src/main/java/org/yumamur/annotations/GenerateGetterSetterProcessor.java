package org.yumamur.annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@SupportedAnnotationTypes("GenerateGetterSetter")
public class GenerateGetterSetterProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateGetterSetter.class)) {
            if (element.getKind() == ElementKind.FIELD) {
                generateGetter(element);
                generateSetter(element);
            }
        }
        return true;
    }

    private void generateGetter(Element element) {
        String fieldName = element.getSimpleName().toString();
        TypeMirror fieldType = element.asType();
        String getterMethodName = "get" + capitalizeFirstLetter(fieldName);

        processingEnv.getMessager().printMessage(
                javax.tools.Diagnostic.Kind.NOTE,
                "Generating getter: " + getterMethodName
        );

        try (PrintWriter writer = new PrintWriter(processingEnv.getFiler().createSourceFile(getterMethodName).openWriter())) {
            writer.println("public " + fieldType + " " + getterMethodName + "() {");
            writer.println("    return this." + fieldName + ";");
            writer.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateSetter(Element element) {
        String fieldName = element.getSimpleName().toString();
        TypeMirror fieldType = element.asType();
        String setterMethodName = "set" + capitalizeFirstLetter(fieldName);

        processingEnv.getMessager().printMessage(
                javax.tools.Diagnostic.Kind.NOTE,
                "Generating setter: " + setterMethodName
        );

        try (PrintWriter writer = new PrintWriter(processingEnv.getFiler().createSourceFile(setterMethodName).openWriter())) {
            writer.println("public void " + setterMethodName + "(" + fieldType + " " + fieldName + ") {");
            writer.println("    this." + fieldName + " = " + fieldName + ";");
            writer.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String capitalizeFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}