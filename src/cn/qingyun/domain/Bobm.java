package cn.qingyun.domain;

/**
 * ��ը��
 * @author ������
 *
 */
public class Bobm {
	
    //��ը����
	int x,y;
	//�жϱ�ը�Ƿ����
	boolean isLive = true;
	//���屬ը��ʱ��
	int bobmLife = 9;
	
	public Bobm(int x,int y){
		this.x = x;
		this.y = y;
	}

	//��ըʱ���1
	public void bobmDown(){
		bobmLife -= 1;
		if(bobmLife == 0){
			isLive = false;
		}
	}
	
	//-----------------------------------------------------
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
