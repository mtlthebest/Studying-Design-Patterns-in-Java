
import wbs.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AbstractTask makeCake = new AbstractTask("�P�[�L���", null);
		
		AbstractTask makeWhippedCream = new AbstractTask("�z�C�b�v�N���[�����", makeCake);
		makeWhippedCream.subTasks.add(new ConcreteTask("�ޗ�������", 100L, makeWhippedCream));
		makeWhippedCream.subTasks.add(new ConcreteTask("�A���Ă�", 1800L, makeWhippedCream));
		
		AbstractTask makeSpongeCake = new AbstractTask("�X�|���W�P�[�L���", makeCake);
		makeSpongeCake.subTasks.add(new ConcreteTask("���n�����", 200L, makeSpongeCake));
		makeSpongeCake.subTasks.add(new ConcreteTask("���n���Ă�", 2000L, makeSpongeCake));
		
		makeCake.subTasks.add(makeWhippedCream);
		makeCake.subTasks.add(makeSpongeCake);

		makeCake.subTasks.add(new ConcreteTask("�f�R���[�g", 100L, makeCake));
		
		AbstractTask wrappingCake = new AbstractTask("�P�[�L�����b�s���O����", makeCake);
		wrappingCake.subTasks.add(new ConcreteTask("�������", 10L, wrappingCake));
		wrappingCake.subTasks.add(new ConcreteTask("���x����\��", 10L, wrappingCake));
		
		AbstractTask manifactureCake = new AbstractTask("�P�[�L�𐻑�����", wrappingCake);
		manifactureCake.subTasks.add(makeCake);
		manifactureCake.subTasks.add(wrappingCake);
		
		long timeInSeconds = manifactureCake.getTimeRequired();
		long minute = timeInSeconds / 60;
		timeInSeconds -= minute * 60;
		long second = timeInSeconds;
		
		for(Task task : manifactureCake){
			System.out.println(task.name);
		}

	}

}
