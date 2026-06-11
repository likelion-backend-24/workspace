package builderexam.builderuser;

public class User {
    private String name;
    private int age;
    private String email;
    private String address;

    private User(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;

    }

    public static Builder builder(){
        return new Builder();
    }

//   static한 내부 클래스 (이 클래스를 통해서 사용자가 객체 생성시 필요한 값들을 채워준다..
    public static class Builder{
        private String name="guest";
        private int age=0;
        private String email;
        private String address;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return  this;
        }
        public Builder email (String email){
            this.email = email;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }

        public User build(){
            return new User(this);
        }
}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
