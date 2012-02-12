
import wbs.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AbstractTask makeWhippedCream = new AbstractTask("�z�C�b�v�N���[�����");
		makeWhippedCream.subTasks.add(new ConcreteTask("�ޗ�������", 100L));
		makeWhippedCream.subTasks.add(new ConcreteTask("�A���Ă�", 1800L));
		
		AbstractTask makeSpongeCake = new AbstractTask("�X�|���W�P�[�L���");
		makeSpongeCake.subTasks.add(new ConcreteTask("���n�����", 200L));
		makeSpongeCake.subTasks.add(new ConcreteTask("���n���Ă�", 2000L));
		
		AbstractTask makeCake = new AbstractTask("�P�[�L���");
		makeCake.subTasks.add(makeWhippedCream);
		makeCake.subTasks.add(makeSpongeCake);
		makeCake.subTasks.add(new ConcreteTask("�f�R���[�g", 100L));
		
		AbstractTask wrappingCake = new AbstractTask("�P�[�L�����b�s���O����");
		wrappingCake.subTasks.add(new ConcreteTask("�������", 10L));
		wrappingCake.subTasks.add(new ConcreteTask("���x����\��", 10L));
		
		AbstractTask manifactureCake = new AbstractTask("�P�[�L�𐻑�����");
		manifactureCake.subTasks.add(makeCake);
		manifactureCake.subTasks.add(wrappingCake);
		
		long timeInSeconds = manifactureCake.getTimeRequired();
		long minute = timeInSeconds / 60;
		timeInSeconds -= minute * 60;
		long second = timeInSeconds;
		
		System.out.println(minute+"��"+second+"�b");

	}

}
