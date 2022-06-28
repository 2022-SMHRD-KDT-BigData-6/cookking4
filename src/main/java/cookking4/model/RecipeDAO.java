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
	List<FavoriteVO> similist = null;
	int cnt = 0;
	
	
	
	///////////////////// ��� ������
	public List<RecipeVO> recipeList() {

		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. sql�� ����
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
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return cnt;	
	}
	
	public List<RefVO> refSelect(int member_id) {
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. sql�� ����
		List<RefVO> list = session.selectList("refSelect", member_id);

		// 3. ������ session ��ȯ
		session.close();

		// 4. �������� ��� ����
		return list;
	}


	// ��ȣ����� ����Ʈ
	public List<FavoriteVO> favoriteSelect(FavoriteVO fvo) {
		try {
			session = sqlSessionFactory.openSession(true);
			favlist = session.selectList("favoriteSelect", fvo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return favlist;
	}

	// ���絵 ������ ����Ʈ
	public List<FavoriteVO> similist(RecipeIdVO recipe_ids){
		try {
			session = sqlSessionFactory.openSession(true);
			similist = session.selectList("similist", recipe_ids);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return similist;
	}
	
	public List<RecipeVO> priceList() {
		
		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. sql�� ����
		List<RecipeVO> list = session.selectList("priceList");

		// 3. ������ session ��ȯ
		session.close();

		// 4. �������� ��� ����
		return list;

	}
}
