package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {
        Memo memo = new Memo(2, "test2");
        jdbcMemoRepository.save(memo);
        Optional<Memo> target = jdbcMemoRepository.findById(2);
        assertEquals("test2", target.get().getText());
    }

    @Test
    void findAll() {
        //given
        List<Memo> all = jdbcMemoRepository.findAll();
        System.out.println(all);

        //when
        //then

     }

}
