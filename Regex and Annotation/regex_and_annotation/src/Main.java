import lombok.Data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//@Data
//class User{
//    @MyNotNull(message="Test annotation!")
//    private String name;
//    private int age;
//    private String email;
//
//    public User(String name, int age, String email) {
//        this.name = name;
//        this.age = age;
//        this.email = email;
//    }
//}
// Retention - time(life) annotation
// Target - this target :)

//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
//@interface MyNotNull{
//    String message();
//}

public class Main {

//    public static void validation(Object obj) throws IllegalAccessException {
//        Class<?> clazz = obj.getClass();
//
//        Field[] fields = clazz.getDeclaredFields();
//        for(Field field : fields){
//            if(field.isAnnotationPresent(MyNotNull.class)){
//                field.setAccessible(true);
//                Object value = field.get(obj);
//                System.out.println("Value: " + value);
//                if(value == null){
//                    MyNotNull annotation = field.getAnnotation(MyNotNull.class);
//                    throw new RuntimeException(field.getName() + " " + annotation.message());
//                }
//            }
//        }
//    }

//     @interface LogLevel {
//        String value() default "INFO";
//    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface LogExecutionTime {
        String value() default "";
    }

    class UserService{
        public  void loadUsers(){
            System.out.println("Loading users...");
        }
    }

    class SaveUserService{
        public  void loadUsers(){
            System.out.println("Save users...");
        }
    }

    class DeleteUserService{
        public  void loadUsers(){
            System.out.println("Delete users...");
        }
    }

    public static void main(String[] args) {
       // validation(new User("ro", 1, "dadada@gmail.com"));
    }
}