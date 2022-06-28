package cookking4.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cookking4.mapper.SqlSessionManager;

public class PriceDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	
	public List<PriceVO> EmartList(String ingr_info_irdnt_nm) {

		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. sql�� ����
		List<PriceVO> list1 = session.selectList("EmartSearch",ingr_info_irdnt_nm);
		
		// 3. ������ session ��ȯ
		session.close();

		// 4. �������� ��� ����
		return list1;

	}
	
	public List<PriceVO> LotteList(String ingr_info_irdnt_nm) {
		
		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2. sql�� ����
		List<PriceVO> list = session.selectList("LotteSearch",ingr_info_irdnt_nm);
		
		// 3. ������ session ��ȯ
		session.close();
		
		// 4. �������� ��� ����
		return list;
		
	}

	public List<PriceVO> HomeList(String ingr_info_irdnt_nm) {
		
		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2. sql�� ����
		List<PriceVO> list = session.selectList("HomeSearch",ingr_info_irdnt_nm);
		
		// 3. ������ session ��ȯ
		session.close();
		
		// 4. �������� ��� ����
		return list;
		
	}
	
}
