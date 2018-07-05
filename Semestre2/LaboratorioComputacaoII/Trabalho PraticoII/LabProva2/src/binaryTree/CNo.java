package binaryTree;
public class CNo {
  public int item;
  public CNo esq, dir;
  public CNo(int vlrItem)
  {
	  item = vlrItem;
	  esq = dir = null;
  }
  
  public CNo()
  {
	  item = 0;
	  esq = dir = null;
  }

  public CNo(int vlrItem, CNo noEsq, CNo noDir)
  {
	  item = vlrItem;
	  esq = noEsq;
	  dir = noDir;
  }  
}
