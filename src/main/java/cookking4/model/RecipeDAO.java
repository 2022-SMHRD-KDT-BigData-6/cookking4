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
	List<FavoriteVO> favlist = null;
	int cnt = 0;
	
	
	///////////////////// ��� ������
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
	
	////////////// �˻��� ������
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

	// ������ �����ֱ�
	public int reviewPoint(RecipeVO pointVO) {
		SqlSession session = sqlSessionFactory.openSession(true);
		try {			
			cnt = session.update("reviewPoint", pointVO);
			System.out.println("review - DAO" + " : " + cnt);
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return cnt;	
	}
	
	public List<RefVO> refSelect(int member_id) {
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. sql�� ����
		// select : 1) selectOne : select���� ����� �ϳ� -> VO
		// 2) selectList : select���� ����� �ټ� -> List<VO>
		// insert delete update : �Ȱ��� �̸��� �޼ҵ� ���
		// selectList("id", parameter)
		// ä���� ���ε� ������ id, ä�ﰪ
		// ������ id��
		List<RefVO> list = session.selectList("refSelect", member_id);

		// 3. ������ session ��ȯ
		session.close();

		// 4. �������� ��� ����
		return list;
	}

	// mart_price sql���� ����

	// mart_price sql���� ����

	// ��ȣ����� ��Ʈ��
	public List<FavoriteVO> favoriteSelect(FavoriteVO fvo) {
		try {
			session = sqlSessionFactory.openSession(true);
			System.out.println("session : " + fvo);
			favlist = session.selectList("favoriteSelect", fvo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return favlist;
	}

	public List<RecipeVO> priceList() {
		
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
		List<RecipeVO> list = session.selectList("priceList");

		// 3. ������ session ��ȯ
		session.close();

		// 4. �������� ��� ����
		return list;

	}
}
