package ssl.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import ssl.dao.BoardDAO;
import ssl.dao.TagDAO;
import ssl.dto.BoardDTO;

public class BoardService
{
	public int writeSS(BoardDTO dto)
	{
		BoardDAO dao = BoardDAO.getinstance();
		String writer_day = null;
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		writer_day = sdf.format(cal.getTime());
		
		return dao.writeSS(dto, writer_day);		
	}
	
	public ArrayList<BoardDTO> getBoardList(String[] tags)
	{
		BoardDAO dao = BoardDAO.getinstance();
		ArrayList<BoardDTO> list = null;
		if(tags == null) list = dao.getAllBoardList();
		else if(tags.length == 1) list = dao.getOneBoardList(tags[0]);
		return list;
	}
	
	public BoardDTO getOneSS(int ss_no)
	{
		BoardDAO dao = BoardDAO.getinstance();
		return dao.getOneSS(ss_no);
	}

	public void modifySS(BoardDTO dto, int ss_no) {
		BoardDAO dao = BoardDAO.getinstance();
		dao.modifySS(dto, ss_no);
	}

	public int getSS_no(int user_no, String title) {
		BoardDAO dao = BoardDAO.getinstance();
		int ss_no = dao.getSS_no(user_no, title);
		return ss_no;
	}

	public void insertTag(int ss_no, String tags) {
		String[] tagValues = tags.split(",");
		TagDAO dao = TagDAO.getinstance();
		int tag_no = 0;
		for(int i=0; i<tagValues.length; i++)
		{
			tag_no = 0;
			if(!(dao.isTag(tagValues[i])))
			{ // 없다면 새로운 태그를 집어넣음.
				dao.insertTag(tagValues[i]);
			}
			// 태그의 번호를 획득함.
			tag_no = dao.getTagNo(tagValues[i]);
			
			// 태그 번호와 태그 이름을 태그리스트 테이블에 삽입함.
			dao.insertTaglist(tagValues[i], tag_no);
		}
		
	}	
}
