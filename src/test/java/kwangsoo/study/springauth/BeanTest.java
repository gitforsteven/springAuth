package kwangsoo.study.springauth;

import kwangsoo.study.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {


    // 두 개의 impl - 해당 3개 처리 안되면 오류처리됨.

    // 1. 빈의 이름으로 선언
    // 현재는 primary 설정되어 있어서 작동 chicken으로 됨
    // defaulit 가 없을 경우는 이런식으로 설정하는게 좋음
    @Autowired
    Food pizza;
    @Autowired
    Food chicken;

    // 2. @qualifier('name') 사용해 지정
    @Autowired
    Food food2;

    // 3.Qualifier 로 지정하기
    @Autowired
    @Qualifier("pizza")
    Food food;


    @Test
    @DisplayName("qualifier 우선순위 확인")
    void test1() {
        food.eat();
        food2.eat();
        pizza.eat();
        chicken.eat();
    }



}