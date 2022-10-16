package com.board.boardprac.mappers;

import com.board.boardprac.beans.vo.BoardVO;
import com.board.boardprac.beans.vo.Criteria;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	@Disabled
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board.toString()));
	}

	@Test
	@Disabled
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글 제목");
		board.setContent("새로 작성한 글 내용");
		board.setWriter("user01");

		mapper.insert(board);
	}

	@Test
//	@Disabled
	public void testInsertSelectKey_bno() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글 제목");
		board.setContent("새로 작성한 글 내용");
		board.setWriter("user02");
		mapper.insertSelectKey_bno(board);
	}

	@Test
	@Disabled
	public void testRead() {
		String str = mapper.read(1L).toString();
		log.info(str);
	}

	@Test
	@Disabled
	public void testDelete() {
		log.info(String.valueOf(mapper.delete(3L)));
	}

	@Test
	@Disabled
	public void testUpdate() {

		Long bno = 1L;

		if (mapper.read(bno) == null) {
			log.info("count: 0");
		}else {

			BoardVO board = new BoardVO();
			//  실행 전 존재하는 글인지 확인
			board.setBno(bno);
			board.setTitle("불꽅놀이");
			board.setContent("재밌겠다");
			board.setWriter("이연준");

			int count = mapper.update(board);
			log.info("count: " + count);
		}
	}

	@Test
	@Disabled
	public void testGetListWithPaging() {
		Criteria cri = new Criteria(2, 2);
		log.info(mapper.getListWithPaging(cri).toString());
	}
}
