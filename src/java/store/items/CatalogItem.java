package store.items;

import store.beans.CatalogBean;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** Describes a catalog item for on-line store. The itemID
 *  uniquely identifies the item, the short description
 *  gives brief info like the book title and author,
 *  the long description describes the item in a couple
 *  of sentences, and the cost gives the current per-item price.
 *  Both the short and long descriptions can contain HTML
 *  markup.
 *  <P>
 *  Based on Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */
@Entity
@Table(name="Users7616485")
public class CatalogItem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final String KIDS = "kids";
    public static final String TECH = "tech";
    private String category;
    @Id
    private String itemID;
    private String shortDescription;
    private String longDescription;
    private double cost;
    
    public CatalogItem(){
        
    }

  public CatalogItem(String category, String itemID, String shortDescription,
                     String longDescription, double cost) {
      this.category = category;
      this.itemID = itemID;
      this.shortDescription = shortDescription;
      this.longDescription = longDescription;
      this.cost = cost;
  }
    
  public String getCategory() {
    return(category);
  }

  protected void setCategory(String category) {
    this.category = category;
  }
  
  public String getItemID() {
    return(itemID);
  }

  protected void setItemID(String itemID) {
    this.itemID = itemID;
  }

  public String getShortDescription() {
    return(shortDescription);
  }

  protected void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getLongDescription() {
    return(longDescription);
  }

  protected void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public double getCost() {
    return(cost);
  }

  protected void setCost(double cost) {
    this.cost = cost;
  }

  public boolean isKids() {
    return this.category.equals(KIDS);
  }
  
  public boolean isTech() {
    return this.category.equals(TECH);
  }
  
      @Override
    public int hashCode() {
        int hash = 0;
        hash += this.itemID.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogItem)) {
            return false;
        }
        CatalogItem other = (CatalogItem)object;
        return (this.itemID.equals(other.itemID));
    }

    @Override
    public String toString() {
        return "dbaccess.persistence.CatalogItem[id=" + itemID + "]";
    }

    /**
     * 
     * @param catalogBean
     * @return true if this User matches the userData bean
     */
    public boolean matches(CatalogBean catalogBean) {
        if (!"".equals(catalogBean.getId()) && !this.getItemID().trim().equals(catalogBean.getId().trim())) {
            return false;
        } 
        return true;
    }
}
