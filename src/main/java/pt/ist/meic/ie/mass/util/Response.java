package pt.ist.meic.ie.mass.util;

public class Response {

    private String type;
    private String msg;

    public Response(String type, String msg){

        this.type = type;
        this.msg = msg;

    }

    public String toJSON() {
        return "{\ntype: " + this.type + "\nmsg: "+ this.msg + "\n}";
    }
}
