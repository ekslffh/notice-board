package com.example.noticeborder.repository;

import com.example.noticeborder.entity.PostEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    // 나는 두개의 Post 객체를 postRepository 에 저장할거야
    @BeforeEach
    public void before() {
        postRepository.deleteAll();
        PostEntity entity1 = PostEntity.builder()
                .title("Harry Porter")
                .content("When Harry was 5 years old")
                        .build();
        postRepository.save(entity1);
        PostEntity entity2 = PostEntity.builder()
                .title("JSP Web Programming")
                .content("interpret and compile with JSP Container ex Tomcat")
                        .build();
        postRepository.save(entity2);
    }

    // 전체 사이즈가 2인지 확인하고(1) 첫번째 객체를 가져와서 내용을 확인해 볼거야(2,3) 첫번째 객체이니깐 id 에는 1L 이 들어있어야 해(4)
    @DisplayName("1. create")
    @Test
    void test_1() {
        List<PostEntity> list = postRepository.findAll();
        // Post 객체를 2개 저장한 상태이므로 전체 사이즈는 2
        assertEquals(2, list.size());
        var entity = list.get(0);
        // 0번째 인덱스의 내용 확인, Id는 1L이 붙어있어야 한다.
        assertEquals("Harry Porter", entity.getTitle());
        assertEquals("When Harry was 5 years old", entity.getContent());
        assertEquals(1L, entity.getId());
    }

    // 아이디 값 2L 을 가지고 두번째 객체를 가져와 볼게 값이 있어야 할거야(1) 또 일치하는지 확인해보고(2,3) 생성일, 수정일도 들어있는지 확인해 볼거야(4,5)
    @DisplayName("2. Read")
    @Test
    void test_2() {
        var optionalEntity = postRepository.get(2L);
        assertTrue(optionalEntity.isPresent());

        var entity = optionalEntity.get();
        assertEquals("JSP Web Programming", entity.getTitle());
        assertEquals("interpret and compile with JSP Container ex Tomcat", entity.getContent());
        assertNotNull(entity.getCreatedAt());
        assertNotNull(entity.getUpdatedAt());
    }

    // 첫번 째 객체를 가져와서 제목을 Harry Porter s2 로 수정해볼게. 수정이니깐 Id 값이 바뀌면 안되겠지? 그리고 내용이 잘 바뀌었는지도 다시 확인해볼거야(2)
    // 마지막으로 수정일이 생성일이랑 달라야 겠지?(3)
    @DisplayName("3. Update")
    @Test
    void test_3() {
        var entity = postRepository.get(1L).orElseThrow();
        String beforeCreatedAt = entity.getCreatedAt().toString();
        String beforeUpdatedAt = entity.getUpdatedAt().toString();
        entity.setTitle("Harry Porter s2");
        postRepository.save(entity);

        var entity2 = postRepository.get(1L).orElseThrow();
        assertEquals("Harry Porter s2", entity2.getTitle());
        assertEquals("When Harry was 5 years old", entity2.getContent());

        String afterCreatedAt = entity2.getCreatedAt().toString();
        String afterUpdatedAt = entity2.getUpdatedAt().toString();
        assertFalse(beforeUpdatedAt.equals(afterUpdatedAt));
        System.out.println("before : " + beforeCreatedAt + " and after : " + afterCreatedAt);
        System.out.println("beforeUpdatedAt : " + beforeUpdatedAt + " and afterUpdatedAt : " + afterUpdatedAt);
    }

    // 첫번째 객체를 아이디 값을 가지고 삭제해볼게 그러면 전체 사이즈가 1로 줄어들어야 해.
    // 중복해서 삭제를 하더라도 오류가 나서는 안돼
    @DisplayName("4. Delete")
    @Test
    void test_4() {
        postRepository.delete(1L);
        assertEquals(1L, postRepository.findAll().size());
        postRepository.delete(1L);
    }

}