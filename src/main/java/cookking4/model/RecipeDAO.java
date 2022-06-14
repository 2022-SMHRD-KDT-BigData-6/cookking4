package cookking4.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cookking4.mapper.SqlSessionManager;

public class RecipeDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	List<RecipeVO> detailvo = null;
	
	public List<RecipeVO> recipeList() {

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
		List<RecipeVO> list = session.selectList("recipeList");

		// 3. ������ session ��ȯ
		session.close();

		// 4. �������� ��� ����
		return list;

	}
	
	public List<RecipeVO> recipeSearchList(String keyword) {
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. sql�� ����
		// select : 1) selectOne : select���� ����� �ϳ� -> VO
		// 2) selectList : select���� ����� �ټ� -> List<VO>
		// insert delete update : �Ȱ��� �̸��� �޼ҵ� ���
		// selectList("id", parameter)
		// ä���� ���ε� ������ id, ä�ﰪ
		// ������ id��
		List<RecipeVO> list = session.selectList("recipeSearch", keyword);

		// 3. ������ session ��ȯ
		session.close();

		// 4. �������� ��� ����
		return list;
		
		
	}

	// Recipe Detail 
	public List<RecipeVO> recipeDetail(int recipeNum) {
		try {
			session = sqlSessionFactory.openSession(true);
			System.out.println("session : " + recipeNum);
			detailvo = session.selectList("recipeDetail", recipeNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return detailvo;
	}
	
	// ������������
	public int recipePage(String keyword) {
		
		int cnt = 0;
		
		try {
			session = sqlSessionFactory.openSession(true);
			System.out.println("session : " + cnt);
			cnt = session.selectOne("recipePage", keyword);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return cnt;
	}
	
}
