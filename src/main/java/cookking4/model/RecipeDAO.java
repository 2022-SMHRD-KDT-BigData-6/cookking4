package cookking4.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cookking4.mapper.SqlSessionManager;

public class RecipeDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();

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
}
