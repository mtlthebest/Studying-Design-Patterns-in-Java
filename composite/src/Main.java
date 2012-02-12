
import wbs.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AbstractTask makeWhippedCream = new AbstractTask("ホイップクリーム作り");
		makeWhippedCream.subTasks.add(new ConcreteTask("材料を入れる", 100L));
		makeWhippedCream.subTasks.add(new ConcreteTask("泡立てる", 1800L));
		
		AbstractTask makeSpongeCake = new AbstractTask("スポンジケーキ作り");
		makeSpongeCake.subTasks.add(new ConcreteTask("生地を作る", 200L));
		makeSpongeCake.subTasks.add(new ConcreteTask("生地を焼く", 2000L));
		
		AbstractTask makeCake = new AbstractTask("ケーキ作り");
		makeCake.subTasks.add(makeWhippedCream);
		makeCake.subTasks.add(makeSpongeCake);
		makeCake.subTasks.add(new ConcreteTask("デコレート", 100L));
		
		AbstractTask wrappingCake = new AbstractTask("ケーキをラッピングする");
		wrappingCake.subTasks.add(new ConcreteTask("箱を作る", 10L));
		wrappingCake.subTasks.add(new ConcreteTask("ラベルを貼る", 10L));
		
		AbstractTask manifactureCake = new AbstractTask("ケーキを製造する");
		manifactureCake.subTasks.add(makeCake);
		manifactureCake.subTasks.add(wrappingCake);
		
		long timeInSeconds = manifactureCake.getTimeRequired();
		long minute = timeInSeconds / 60;
		timeInSeconds -= minute * 60;
		long second = timeInSeconds;
		
		System.out.println(minute+"分"+second+"秒");

	}

}
