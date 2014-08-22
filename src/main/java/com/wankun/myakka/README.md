# 程序说明：
	AKKA 是一款基于actor模型实现的 并发处理框架。
	基于事件驱动的并发处理模型，每一个actor拥有自己的属性和操作，这样就避免了通常情况下因为多个线程之间要共享属性（数据）而是用锁机制的处理。
	这种机制在scala，cloure 语言中应用的很好，将操作和属性放在一个独立的单元中进行处理，从而提高并发处理的能力。

### 功能描述：
	HelloWorld actor ----tell.Msg.GREET--> Greeter ---> 处理事件
	HelloWorld actor <----stop(getSelf())<-- Greeter
	
	实现通过一个actior发送消息到另一个actor然后将处理结果返回，感觉很简单类似两个类的方法调用，但是这里实际上的处理时异步的并非同步的调用处理.
		
### 允许测试：
	在eclipse中在helloworld类中点击 open run dailoge，然后在Main.class 选项中输入akka.Main，然后选择arguments 在program arguments 中输入 com.wankun.myakka.HelloWorld，点击 apply 然后运行.