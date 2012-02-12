
import wbs.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AbstractTask makeCake = new AbstractTask("ケーキ作り", null);
		
		AbstractTask makeWhippedCream = new AbstractTask("ホイップクリーム作り", makeCake);
		makeWhippedCream.subTasks.add(new ConcreteTask("材料を入れる", 100L, makeWhippedCream));
		makeWhippedCream.subTasks.add(new ConcreteTask("泡立てる", 1800L, makeWhippedCream));
		
		AbstractTask makeSpongeCake = new AbstractTask("スポンジケーキ作り", makeCake);
		makeSpongeCake.subTasks.add(new ConcreteTask("生地を作る", 200L, makeSpongeCake));
		makeSpongeCake.subTasks.add(new ConcreteTask("生地を焼く", 2000L, makeSpongeCake));
		
		makeCake.subTasks.add(makeWhippedCream);
		makeCake.subTasks.add(makeSpongeCake);

		makeCake.subTasks.add(new ConcreteTask("デコレート", 100L, makeCake));
		
		AbstractTask wrappingCake = new AbstractTask("ケーキをラッピングする", makeCake);
		wrappingCake.subTasks.add(new ConcreteTask("箱を作る", 10L, wrappingCake));
		wrappingCake.subTasks.add(new ConcreteTask("ラベルを貼る", 10L, wrappingCake));
		
		AbstractTask manifactureCake = new AbstractTask("ケーキを製造する", wrappingCake);
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
