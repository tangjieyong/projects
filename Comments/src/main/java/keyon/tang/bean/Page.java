package keyon.tang.bean;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/25 20:54
 * @Version 1.0
 */
public class Page {
    private int  currentPage;
    private int  totalPages;
    private int pageCapacity;
    private int totalCapacity;
    private int dbCurrentCapacity;
    private int dbPastSum;

    public Page() {
        this. currentPage=1;
        this.pageCapacity=3; //默认每页显示3条

    }

    public Page(int currentPage, int totalPages, int pageCapacity, int totalCapacity, int dbCurrentCapacity, int dbPastSum) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.pageCapacity = pageCapacity;
        this.totalCapacity = totalCapacity;
        this.dbCurrentCapacity = dbCurrentCapacity;
        this.dbPastSum = dbPastSum;
    }

     public void count(){
//        处理页面总数
         if(totalCapacity!=0){
             int totalPagesTemp=this.totalCapacity/this.pageCapacity;
             int plus=(this.totalCapacity%this.pageCapacity)==0? 0:1;
             this.totalPages=totalPagesTemp+plus;

//可能查出的总记录数为零，这时让当前页面显示为第一页
             if(totalPagesTemp<1)
                 this.currentPage=1;

// 可能计算得出的页面总数小于当前的页面,这时让总页面为当前页面
             if(this.totalPages<this.currentPage)
                 this.totalPages=this.currentPage;

// 处理与sql语句有关的属性
             this.dbCurrentCapacity =this.pageCapacity;
             this.dbPastSum =(this.currentPage-1)*this.pageCapacity;
         }}

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageCapacity() {
        return pageCapacity;
    }

    public void setPageCapacity(int pageCapacity) {
        this.pageCapacity = pageCapacity;
        count();
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        count();
    }

    public int getDbCurrentCapacity() {
        return dbCurrentCapacity;
    }

    public void setDbCurrentCapacity(int dbCurrentCapacity) {
        this.dbCurrentCapacity = dbCurrentCapacity;
    }

    public int getDbPastSum() {
        return dbPastSum;
    }

    public void setDbPastSum(int dbPastSum) {
        this.dbPastSum = dbPastSum;
    }


    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", pageCapacity=" + pageCapacity +
                ", totalCapacity=" + totalCapacity +
                ", dbCurrentCapacity=" + dbCurrentCapacity +
                ", dbPastSum=" + dbPastSum +
                '}';
    }
}
