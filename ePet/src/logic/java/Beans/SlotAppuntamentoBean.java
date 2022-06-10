package Beans;

public class SlotAppuntamentoBean {
    private String post;
    private String date;
    private String address;
    private Boolean occupato;

    public SlotAppuntamentoBean(){
        //default
    }
    public SlotAppuntamentoBean(String p, String d, String add, Boolean occ){
        this.post=p;
        this.date=d;
        this.address=add;
        this.occupato=occ;
    }

    public String getPost() {
        return this.post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getOccupato() {
        return this.occupato;
    }

    public void setOccupato(Boolean occupato) {
        this.occupato = occupato;
    }
}
