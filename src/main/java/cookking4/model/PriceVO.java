package cookking4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // �⺻ �޼ҵ常 ����(Getter/Setter, toString)
@AllArgsConstructor // ��� ��Ҹ� �Ű������� ���� ������.
@NoArgsConstructor
public class PriceVO {

	private int mart_num;
	private String mart_name;
	private String ingr_name;
	private String price;
	private String price_100;
	private int ingr_info_irdnt_sn;
	private String ingr_info_irdnt_nm;
	
	
	
}
