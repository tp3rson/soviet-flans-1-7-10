package alexsocol.asjlib.asm;

public class ASMExample {

	@HookField(targetClassName = "alexsocol.asjlib.asm.ASMTestClass")
	public int test;
	
	@HookField(targetClassName = "alexsocol.asjlib.asm.ASMTestClass")
	public static Integer Itest;
}
