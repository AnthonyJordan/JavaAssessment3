package parsing_json;

import java.beans.Expression;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElementCollection extends ArrayList<Element>{


    public Element findByAtomicNumber(int atomic_number) {
        for (Element element: this) {
            if (element.getNumber() == atomic_number){
                return element;
            }
        }
        return null;
    }

    public Element findByName(String name) {
        for (Element element: this) {
            if (element.getName().equals(name)){
                return element;
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
        ElementCollection newCollection = new ElementCollection();
        Method[] methods = Element.class.getMethods();
        Method methodToUse = null;
        Pattern pattern = Pattern.compile("(?i)" + fieldName +"$");
        Matcher matcher;
        for (Method method: methods) {
            matcher = pattern.matcher(method.getName());
            if (matcher.find(0)){
                methodToUse = method;
            }
        }
        try {
            for (Element element : this) {
                if (methodToUse.invoke(element).equals(value)) {
                    newCollection.add(element);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return newCollection;
    }
}
