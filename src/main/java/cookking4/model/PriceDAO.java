package cookking4.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cookking4.mapper.SqlSessionManager;

public class PriceDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	
	public List<PriceVO> EmartList() {

		// 1. SqlSession ��������
		// openSession(auto commit);
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. sql�� ����
		// select : 1) selectOne : select���� ����� �ϳ� -> VO
		// 2) selectList : select���� ����� �ټ� -> List<VO>
		// insert delete update : �Ȱ��� �̸��� �޼ҵ� ���
		// selectList("id", parameter)
		// ä���� ���ε� ������ id, ä�ﰪ
		// ������ id��
		List<PriceVO> list1 = session.selectList("EmartSearch");
		

		// 3. ������ session ��ȯ
		session.close();

		// 4. �������� ��� ����
		return list1;

	}
	public List<PriceVO> LotteList() {
		
		// 1. SqlSession ��������
		// openSession(auto commit);
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2. sql�� ����
		// select : 1) selectOne : select���� ����� �ϳ� -> VO
		// 2) selectList : select���� ����� �ټ� -> List<VO>
		// insert delete update : �Ȱ��� �̸��� �޼ҵ� ���
		// selectList("id", parameter)
		// ä���� ���ε� ������ id, ä�ﰪ
		// ������ id��
		List<PriceVO> list = session.selectList("LotteSearch");
		
		
		// 3. ������ session ��ȯ
		session.close();
		
		// 4. �������� ��� ����
		return list;
		
	}
	public List<PriceVO> HomeList() {
		
		// 1. SqlSession ��������
		// openSession(auto commit);
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2. sql�� ����
		// select : 1) selectOne : select���� ����� �ϳ� -> VO
		// 2) selectList : select���� ����� �ټ� -> List<VO>
		// insert delete update : �Ȱ��� �̸��� �޼ҵ� ���
		// selectList("id", parameter)
		// ä���� ���ε� ������ id, ä�ﰪ
		// ������ id��
		List<PriceVO> list = session.selectList("HomeSearch");
		
		
		// 3. ������ session ��ȯ
		session.close();
		
		// 4. �������� ��� ����
		return list;
		
	}
	
}
