import javax.persistence.PersistenceContext;

public class TestPersistenceContext {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class clz=Class.forName("dao.jpa.CollegeRepositoryJpa");
		PersistenceContext pc=clz.getDeclaredField("em").getAnnotation(PersistenceContext.class);
		System.out.println(pc.synchronization());

	}

}
