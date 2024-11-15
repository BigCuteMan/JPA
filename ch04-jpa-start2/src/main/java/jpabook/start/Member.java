package jpabook.start;

import javax.persistence.*;

@Entity // 이 클래스를 테이블과 매핑한다고 JPA에 알려줌
@Table(name="MEMBER")
public class Member {

    @Id
    @Column(name="ID")
    private String id;

    @Column(name = "NAME")
    private String username;
    private Integer age;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}