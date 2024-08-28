package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JpaMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo memo = new Memo(10, "this is jpa memo");

        //when
        jpaMemoRepository.save(memo);

        //then
        List<Memo> memoList = jpaMemoRepository.findAll();

        assertTrue(!memoList.isEmpty());
     }

     @Test
     void findByIdTest() {
         //given
         Memo newMemo = new Memo(11, "jpa");

         //when
         Memo save = jpaMemoRepository.save(newMemo);
         System.out.println(save.getId());

         Optional<Memo> byId = jpaMemoRepository.findById(11);

         //then
         assertEquals("jap", byId.get().getText());
      }
}
