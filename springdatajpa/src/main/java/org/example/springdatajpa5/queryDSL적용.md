Spring Data JPA 프로젝트에 QueryDSL을 적용하는 순서

## 1. QueryDSL 의존성 추가

다음은 `build.gradle`에 대한 예제입니다.

```gradle
dependencies {

    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

    // QueryDSL
    implementation 'com.querydsl:querydsl-jpa:5.1.0:jakarta'

    annotationProcessor 'com.querydsl:querydsl-apt:5.1.0:jakarta'
    annotationProcessor 'jakarta.persistence:jakarta.persistence-api'
    annotationProcessor 'jakarta.annotation:jakarta.annotation-api'

    runtimeOnly 'com.mysql:mysql-connector-j'

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```
## 2. 엔티티 생성 

```java 
    @Entity
@Setter
@Getter
@Table(name = "jpa_user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

```
---

## 3. Gradle 새로고침

IntelliJ

```text
Gradle
→ Reload All Gradle Projects
```

또는
맥
```bash
gradlew clean compileJava
```
윈도우
```bash
.\gradlew.bat clean compileJava
```

실행

---

## 4. Q 클래스 생성 확인

- build/generated/sources/annotationProcessor/java/main   


엔티티가 있다면

```java
@Entity
public class User {

    @Id
    private Long id;

    private String name;

    private String email;
}
```

빌드 후 아래 파일이 생성되어야 합니다.

```text
build
 └─ generated
     └─ sources
         └─ annotationProcessor
             └─ java
                 └─ main
                     └─ com.example
                         └─ QUser.java
```

---

## 4. IntelliJ 설정

반드시 아래 설정으로 변경합니다.

```text
Settings
 └ Build, Execution, Deployment
    └ Build Tools
       └ Gradle
```

다음과 같이 설정

```text
Build and run using : Gradle

Run tests using : Gradle
```

주의

```text
IntelliJ IDEA
```

로 설정하면 QueryDSL의 Q 클래스가 인식되지 않는 경우가 많습니다.

---

## 5. QueryDSL 설정 클래스 작성

다음은 QueryDSL 설정 예제입니다.

```java
package com.example.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslConfig {

    @Bean
    public JPAQueryFactory jpaQueryFactory(
            EntityManager entityManager
    ) {
        return new JPAQueryFactory(entityManager);
    }
}
```

---

## 6. Custom Repository 생성

다음은 Custom Repository 인터페이스 예제입니다.

```java
package com.example.repository;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> findUsersByName(String name);

    List<User> findUsersDynamically(
            String name,
            String email
    );
}
```

---

## 7. Repository 연결

다음은 Repository 예제입니다.

```java
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long>,
                UserRepositoryCustom {
}
```

---

## 8. QueryDSL 구현

주의

```text
UserRepositoryCustom
UserRepositoryCustomImpl
```

이름을 정확히 맞춰야 합니다.

다음은 구현 예제입니다.

```java
package com.example.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.repository.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl
        implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<User> findUsersByName(String name) {

        return queryFactory
                .selectFrom(user)
                .where(user.name.contains(name))
                .fetch();
    }

    @Override
    public List<User> findUsersDynamically(
            String name,
            String email
    ) {

        return queryFactory
                .selectFrom(user)
                .where(
                        nameEq(name),
                        emailEq(email)
                )
                .fetch();
    }

    private BooleanExpression nameEq(
            String name
    ) {
        return name == null || name.isBlank()
                ? null
                : user.name.eq(name);
    }

    private BooleanExpression emailEq(
            String email
    ) {
        return email == null || email.isBlank()
                ? null
                : user.email.eq(email);
    }
}
```

---

## 9. 사용 예제

다음은 QueryDSL 사용 예제입니다.

```java
List<User> users =
        userRepository.findUsersDynamically(
                "kim",
                null
        );

users.forEach(System.out::println);
```

---

## QueryDSL의 장점

### JPQL

```java
@Query("""
       select u
       from User u
       where u.name = :name
       """)
List<User> findByName(String name);
```

* 문자열 기반
* 오타를 컴파일 시 발견 불가

---

### Criteria API

```java
CriteriaBuilder cb =
        entityManager.getCriteriaBuilder();

CriteriaQuery<User> query =
        cb.createQuery(User.class);
```

* 타입 안전
* 코드가 매우 복잡

---

### QueryDSL

```java
return queryFactory
        .selectFrom(user)
        .where(user.name.eq(name))
        .fetch();
```

* 타입 안전
* 코드가 간결
* 동적 쿼리 작성이 쉬움

---

## 가장 많이 발생하는 오류

### QUser 오류 발생

확인 순서

```text
1. build.gradle 의존성 확인

2. gradlew clean compileJava 실행

3. QUser 생성 여부 확인

4. Gradle Reload

5. Build and run using : Gradle

6. Run tests using : Gradle
```

가장 많이 발생하는 원인

```text
Build and run using : IntelliJ IDEA
```


반드시

```text
Build and run using : Gradle
Run tests using : Gradle
```

로 변경합니다.

---
