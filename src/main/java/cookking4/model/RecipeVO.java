package cookking4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data // �⺻ �޼ҵ常 ����(Getter/Setter, toString)
@AllArgsConstructor // ��� ��Ҹ� �Ű������� ���� ������.
@NoArgsConstructor
public class RecipeVO {

	private int recipe_id;
	private String recipe_name;
	private String summary;
	private int food_code;
	private String food_type;
	private String cooking_time;
	private String calorie;
	private String amount;
	private String food_level;
	private int step_no;
	private String cooking_desc;
	private String step_img_url;
	private String step_tip;
	private int point;
	
	// mart_price ���̺�
	private int mart_num;
	private String mart_name;
	private String ingr_name;
	private String price;
	private String price_100;
	private int ingr_info_irdnt_sn;
	private int ingr_info_irdnt_nm;
	
}
