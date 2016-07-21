class Var{
private String type;
private String indificator;
private String value;

    public void setType(String type) {
        this.type = type;
    }

    public void setIndificator(String indificator) {
        this.indificator = indificator;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getIndificator() {
        return indificator;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return  "type=" + type + ", indificator=" + indificator + ", value=" + value ;
    }
    

}