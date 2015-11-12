package tree;
class RbtNode<E extends Comparable<E>,F>
{
	private E key;
	private F val;
	private boolean color;
	private RbtNode<E,F> p,l,r;
	//constructors
	public RbtNode()
	{
		key=null;
		val=null;
		p=null;
		l=null;
		r=null;
	}
	public RbtNode(E key,F val)
	{
		this.key=key;
		this.val=val;
		p=null;
		l=null;
		r=null;
	}
	//Element access methods
	public void setP(RbtNode<E,F> link)
	{
		this.p=link;
	}
	public void setL(RbtNode<E,F> link)
	{
		this.l=link;
	}
	public void setR(RbtNode<E,F> link)
	{
		this.r=link;
	}
	public void setKey(E key)
	{
		this.key=key;
	}
	public void setVal(F val)
	{
		this.val=val;
	}
	public void setColor(boolean col)
	{
		this.color=col;
	}
	public RbtNode<E,F> getP()
	{
		return this.p;
	}
	public RbtNode<E,F> getL()
	{
		return this.l;
	}
	public RbtNode<E,F> getR()
	{
		return this.r;
	}
	public E getKey()
	{
		return this.key;
	}
	public F getVal()
	{
		return this.val;
	}
	public boolean getColor()
	{
		return this.color;
	}
}
public class RBT<E extends Comparable<E>,F>
{
	//variables and constants
	private RbtNode<E,F> root;
	private RbtNode<E,F> tnil=new RbtNode<E,F>();
	final boolean BLACK=true;
	final boolean RED=false;
	//constructors
	public RBT()
	{
		root=null;
		tnil.setP(null);
		tnil.setL(null);
		tnil.setR(null);
		tnil.setColor(BLACK);
	}
	//methods
	public RbtNode<E,F> getRoot()
	{
		return this.root;
	}
	public RbtNode<E,F> searchNode(E key)
	{
		if(root==null||root==tnil)
			return null;
		else
		{
			RbtNode<E,F> trv=root;
			RbtNode<E,F> prt=root;
			E tkey=trv.getKey();
			while(tkey.compareTo(key)!=0 && trv!=tnil && trv!=null)
			{
				tkey=trv.getKey();
				prt=trv;
				if(key.compareTo(tkey)<0)
					trv=trv.getL();
				else
					trv=trv.getR();
			}
			if(prt.getKey().compareTo(key)!=0)
				return null;
			return prt;
		}
	}
	public RbtNode<E,F> getMin(RbtNode<E,F> trv)
	{
		if(trv==null)
			return null;
		while(trv.getL()!=tnil)
			trv=trv.getL();
		return trv;
	}
	public RbtNode<E,F> getMax(RbtNode<E,F> trv)
	{
		if(trv==null)
			return null;
		while(trv.getR()!=tnil)
			trv=trv.getR();
		return trv;
	}
	public void transplant(RbtNode<E,F> u,RbtNode<E,F> v)
	{
		if(u.getP()==tnil)
			root=v;
		else if(u.getP().getL()==u)
			u.getP().setL(v);
		else
			u.getP().setR(v);
		v.setP(u.getP());
	}
	public void rotateL(RbtNode<E,F> x)
	{
		RbtNode<E,F> y=x.getR();
		x.setR(y.getL());
		if(y.getL()!=tnil)
			y.getL().setP(x);
		y.setP(x.getP());
		if(x.getP()==tnil)
			root=y;
		else if(x.getP().getL()==x)
			x.getP().setL(y);
		else
			x.getP().setR(y);
		y.setL(x);
		x.setP(y);
	}
	public void rotateR(RbtNode<E,F> y)
	{
		RbtNode<E,F> x=y.getL();
		y.setL(x.getR());
		if(x.getR()!=tnil)
			x.getR().setP(y);
		x.setP(y.getP());
		if(y.getP()==tnil)
			root=x;
		else if(y.getP().getR()==y)
			y.getP().setR(x);
		else
			y.getP().setL(x);
		x.setR(y);
		y.setP(x);
	}
	public void insRbtFixup(RbtNode<E,F> z)
	{
		RbtNode<E,F> y;
		while(z.getP().getColor()==RED)
		{
			if(z.getP()==z.getP().getP().getL())
			{
				y=z.getP().getP().getR();
				if(y.getColor()==RED)
				{
					y.setColor(BLACK);
					z.getP().setColor(BLACK);
					z.getP().getP().setColor(RED);
					z=z.getP().getP();
				}
				else
				{
					if(z==z.getP().getR())
					{
						z=z.getP();
						rotateL(z);
					}
					z.getP().setColor(BLACK);
					z.getP().getP().setColor(RED);
					rotateR(z.getP().getP());
				}
			}
			else
			{
				y=z.getP().getP().getL();
				if(y.getColor()==RED)
				{
					y.setColor(BLACK);
					z.getP().setColor(BLACK);
					z.getP().getP().setColor(RED);
					z=z.getP().getP();
				}
				else
				{
					if(z==z.getP().getL())
					{
						z=z.getP();
						rotateR(z);
					}
					z.getP().setColor(BLACK);
					z.getP().getP().setColor(RED);
					rotateL(z.getP().getP());
				}
			}
		}
		root.setColor(BLACK);
	}
	public void insRbt(E key,F val)
	{
		RbtNode<E,F> z=new RbtNode<>(key,val);
		RbtNode<E,F> y=tnil;
		RbtNode<E,F> x=root;
		while(x!=tnil && x!=null)
		{
			y=x;
			if(key.compareTo(x.getKey())<0)
				x=x.getL();
			else
				x=x.getR();
		}
		z.setP(y);
		if(y==tnil)
			root=z;
		else if(z.getKey().compareTo(y.getKey())<0)
			y.setL(z);
		else
			y.setR(z);
		z.setL(tnil);
		z.setR(tnil);
		z.setColor(RED);
		//fix the raised problem by insRbtFixup
		insRbtFixup(z);
	}
	public void delRbtFixup(RbtNode<E,F> x)
	{
		while(x!=root && x.getColor()==BLACK)
		{
			RbtNode<E,F> w;
			if(x==x.getP().getL())
			{
				w=x.getP().getR();
				if(w.getColor()==RED)
				{
					w.setColor(BLACK);
					x.getP().setColor(RED);
					rotateL(x.getP());
					w=x.getP().getR();
				}
				if(w.getL().getColor()==BLACK && w.getR().getColor()==BLACK)
				{
					w.setColor(RED);
					x=x.getP();
				}
				else
				{
					if(w.getR().getColor()==BLACK)
					{
						w.getL().setColor(BLACK);
						w.setColor(RED);
						rotateR(w);
						w=x.getP().getR();
					}
					w.setColor(x.getP().getColor());
					x.getP().setColor(BLACK);
					w.getR().setColor(BLACK);
					rotateL(x.getP());
					x=root;
				}
			}
			else
			{
				w=x.getP().getL();
				if(w.getColor()==RED)
				{
					w.setColor(BLACK);
					x.getP().setColor(RED);
					rotateR(x.getP());
					w=x.getP().getL();
				}
				if(w.getR().getColor()==BLACK && w.getL().getColor()==BLACK)
				{
					w.setColor(RED);
					x=x.getP();
				}
				else
				{
					if(w.getL().getColor()==BLACK)
					{
						w.getR().setColor(BLACK);
						w.setColor(RED);
						rotateL(w);
						w=x.getP().getL();
					}
					w.setColor(x.getP().getColor());
					x.getP().setColor(BLACK);
					w.getL().setColor(BLACK);
					rotateR(x.getP());
					x=root;
				}
			}
		}
		x.setColor(BLACK);
	}
	public void delRbt(E key)
	{
		RbtNode<E,F> z=searchNode(key);
		if(z!=null)
		{
			RbtNode<E,F> x,y=z;
			boolean origCol=y.getColor();
			if(y.getL()==tnil)
			{
				x=z.getR();
				transplant(z,z.getR());
			}
			else if(y.getR()==tnil)
			{
				x=z.getL();
				transplant(z,z.getL());
			}
			else
			{
				y=getMin(z.getR());
				origCol=y.getColor();
				x=y.getR();
				if(y.getP()==z)
					x.setP(y);
				else
				{
					transplant(y,y.getR());
					y.setR(z.getR());
					y.getR().setP(y);
				}
				transplant(z,y);
				y.setL(z.getL());
				y.getL().setP(y);
				y.setColor(z.getColor());
			}
			//fix the raised problems
			if(origCol==BLACK)
				delRbtFixup(x);
		}
		else
			System.out.println("Key not found");
	}
	public void showInorder(RbtNode<E,F> trv)
	{
		if(trv==tnil||trv==null)
			return;
		showInorder(trv.getL());
		System.out.println(	trv.getKey()+"--->"+
							trv.getVal()+"--->"+
							((trv.getColor()==true)?"BLACK":"RED")+
							((trv==root)?"--->ROOT":"")
						  );
		showInorder(trv.getR());
	}
}