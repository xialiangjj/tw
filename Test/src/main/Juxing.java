package main;

public class Juxing {
	
	private Point leftUp;
	private Point rightUp;
	private Point leftDown;
	private Point rightDown;
	
	public Juxing(Point leftUp,Point rightDown){
		this.leftUp=leftUp;
		this.rightDown=rightDown;
		
		this.rightUp=new Point(rightDown.getX(),leftUp.getY());
		this.leftDown = new Point(leftUp.getX(),rightDown.getY());
	}
	
	public boolean compare(Juxing jx) {
		Point p = jx.getLeftUp();
		if(this.comparePoint(p))
			return true;
		p = jx.getLeftDown();
		if(this.comparePoint(p))
			return true;
		p = jx.getRightUp();
		if(this.comparePoint(p))
			return true;
		p = jx.getRightDown();
		if(this.comparePoint(p))
			return true;
		return false;
		
		
	}
	
	private boolean comparePoint(Point p) {
		int x = this.getLeftDown().getX();
		int x2 = this.getRightUp().getX();
		
		int y = this.getLeftDown().getY();
		int y2 = this.getRightUp().getY();
		if(p.getX()>=x&&p.getX()<=x2 && p.getY()>=y2 && p.getY()<=y)
			return true;
		return false;
	}

	public Point getLeftUp() {
		return leftUp;
	}

	public void setLeftUp(Point leftUp) {
		this.leftUp = leftUp;
	}

	public Point getRightUp() {
		return rightUp;
	}

	public void setRightUp(Point rightUp) {
		this.rightUp = rightUp;
	}

	public Point getLeftDown() {
		return leftDown;
	}

	public void setLeftDown(Point leftDown) {
		this.leftDown = leftDown;
	}

	public Point getRightDown() {
		return rightDown;
	}

	public void setRightDown(Point rightDown) {
		this.rightDown = rightDown;
	}
	
	
}
