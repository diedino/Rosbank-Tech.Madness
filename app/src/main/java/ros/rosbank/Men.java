package ros.rosbank;

public class Men {

    private String name;
    private String typeOfService;
    private boolean status;
    private int profit;
    private String id;
    private String date;

    public Men(String name, String typeOfService, boolean status, int profit, String id, String date){

        this.name=name;
        this.typeOfService=typeOfService;
        this.status=status;
        this.profit = profit;
        this.id = id;
        this.date = date;
    }
    public String getDate() { return this.date; }

    public void setDate(String date) {this.date = date;}

    public String getId() { return this.id; }

    public void setId(String id) {this.id = id;}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return this.typeOfService;
    }

    public void setService(String service) {
        this.typeOfService = service;
    }

    public String getStatus() {
        return this.status ? "Accepted" : "Not accepted";
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getProfit(){
        return this.profit;
    }

    public  void setProfit(int profit){
        this.profit = profit;
    }
}