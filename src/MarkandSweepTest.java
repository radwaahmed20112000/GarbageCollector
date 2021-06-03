import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;


class MarkandSweepTest {
	GarbageCollector garbage = new GarbageCollector();

	@Test
	void test() {
		LinkedList<String> roots = new LinkedList<>();
		roots.add("222222");
		roots.add("555555");
		garbage.setRoots(roots);
		garbage.markAndSweep();
		assertEquals(garbage.getGraph().getGraph().size(),5);
	}

}
