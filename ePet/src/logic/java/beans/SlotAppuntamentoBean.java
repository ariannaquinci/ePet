package beans;

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

    public void setPost(String p) {
        this.post = p;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String data) {
        this.date = data;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String add) {
        this.address = add;
    }

    public Boolean getOccupato() {
        return this.occupato;
    }

    public void setOccupato(Boolean occ) {
        this.occupato = occ;
    }
}
