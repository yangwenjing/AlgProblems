/**
 * 
 */


/**
 * @author Yang Wenjing
 * ����
 *
 */
public class Queue<E> {
	//�������飬�������洢a.length-1������
	E[] a;
	//Ĭ�ϳ�ʼ����С
	private static final int DEFAULT_SIZE=10000;//100*100
	//�����±�
	int front;
	//��β�±�
	int rear;
	
	public Queue(){
		this(DEFAULT_SIZE);
	}
	/**
	 * ��ʼ��ָ�����ȵĶ���
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public Queue(int size){
		a=(E[])(new Object[size]);
		front=0;
		rear=0;
	}
	
	/**
	 * ��һ������׷�ӵ�����β��
	 * @param obj
	 * @return ������ʱ����false,���򷵻�true
	 * @author WWX
	 */
	public boolean enqueue(E obj){
		if((rear+1)%a.length==front){
			return false;
		}else{
			a[rear]=obj;
			rear=(rear+1)%a.length;
			return true;
		}
	}
	
	/**
	 * ����ͷ������
	 * @return
	 * @author WWX
	 */
	public E dequeue(){
		if(rear==front)
			return null;
		else{
			E obj =a[front];
			front=(front+1)%a.length;
			return obj;
		}
	}
	
	/**
	 * ���г���
	 * @return
	 * @author WWX
	 */
	public int size(){
		return (rear-front)&(a.length-1);
	}
	//���г��ȣ���һ�ַ�����
	public int length(){
		if(rear>front){
			return rear-front;
		}else
			return a.length-1;
	}
	
	/**
	 * �ж��Ƿ�Ϊ�� 
	 * @return
	 * @author WWX
	 */
	public boolean isEmpty(){
		return rear==front;
	}
	


//	public static void main(String[] args) {
//		CirQueue<String> queue=new CirQueue<String>(4);
//		queue.enqueue("1");
//		queue.enqueue("2");
//		queue.enqueue("3");
//		System.out.println("size="+queue.size());
//		int size=queue.size();
//		System.out.println("*******��ջ����*******");
//		for(int i=0; i<size;i++){
//			System.out.print(queue.dequeue()+" ");
//		}
//		
//	}
	
}
