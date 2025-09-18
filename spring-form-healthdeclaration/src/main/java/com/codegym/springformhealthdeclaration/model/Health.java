package com.codegym.springformhealthdeclaration.model;

public class Health {
    private String fullName;
    private Integer yearOfBirth;
    private String gender;
    private String nationality;
    private String idNumber;
    private String travelInfo;
    private String vehicleNumber;
    private String seatNumber;
    private String departureDate;
    private String endDate;
    private String visitedPlaces;
    private String address;
    private String city;
    private String phone;
    private String email;
    private boolean sot;
    private boolean ho;
    private boolean kho_tho;
    private boolean dau_hong;
    private boolean non_buon_non;
    private boolean tieu_chay;
    private boolean xuat_huyet_ngoai_da;
    private boolean noi_ban_ngoai_da;
    private boolean phoi_nhiem_1;
    private boolean phoi_nhiem_2;

    public Health() {
    }

    public Health(Integer yearOfBirth, String gender, String nationality, String idNumber, String travelInfo, String vehicleNumber, String seatNumber, String departureDate, String endDate, String visitedPlaces, String address, String city, String phone, String email, boolean sot, boolean ho, boolean kho_tho, boolean dau_hong, boolean non_buon_non, boolean tieu_chay, boolean xuat_huyet_ngoai_da, boolean noi_ban_ngoai_da, boolean phoi_nhiem_1, boolean phoi_nhiem_2) {
        this.setYearOfBirth(yearOfBirth);
        this.setGender(gender);
        this.setNationality(nationality);
        this.setIdNumber(idNumber);
        this.setTravelInfo(travelInfo);
        this.setVehicleNumber(vehicleNumber);
        this.setSeatNumber(seatNumber);
        this.setDepartureDate(departureDate);
        this.setEndDate(endDate);
        this.setVisitedPlaces(visitedPlaces);
        this.setAddress(address);
        this.setCity(city);
        this.setPhone(phone);
        this.setEmail(email);
        this.setSot(sot);
        this.setHo(ho);
        this.setKho_tho(kho_tho);
        this.setDau_hong(dau_hong);
        this.setNon_buon_non(non_buon_non);
        this.setTieu_chay(tieu_chay);
        this.setXuat_huyet_ngoai_da(xuat_huyet_ngoai_da);
        this.setNoi_ban_ngoai_da(noi_ban_ngoai_da);
        this.setPhoi_nhiem_1(phoi_nhiem_1);
        this.setPhoi_nhiem_2(phoi_nhiem_2);
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(String travelInfo) {
        this.travelInfo = travelInfo;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVisitedPlaces() {
        return visitedPlaces;
    }

    public void setVisitedPlaces(String visitedPlaces) {
        this.visitedPlaces = visitedPlaces;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSot() {
        return sot;
    }

    public void setSot(boolean sot) {
        this.sot = sot;
    }

    public boolean isHo() {
        return ho;
    }

    public void setHo(boolean ho) {
        this.ho = ho;
    }

    public boolean isKho_tho() {
        return kho_tho;
    }

    public void setKho_tho(boolean kho_tho) {
        this.kho_tho = kho_tho;
    }

    public boolean isDau_hong() {
        return dau_hong;
    }

    public void setDau_hong(boolean dau_hong) {
        this.dau_hong = dau_hong;
    }

    public boolean isNon_buon_non() {
        return non_buon_non;
    }

    public void setNon_buon_non(boolean non_buon_non) {
        this.non_buon_non = non_buon_non;
    }

    public boolean isTieu_chay() {
        return tieu_chay;
    }

    public void setTieu_chay(boolean tieu_chay) {
        this.tieu_chay = tieu_chay;
    }

    public boolean isXuat_huyet_ngoai_da() {
        return xuat_huyet_ngoai_da;
    }

    public void setXuat_huyet_ngoai_da(boolean xuat_huyet_ngoai_da) {
        this.xuat_huyet_ngoai_da = xuat_huyet_ngoai_da;
    }

    public boolean isNoi_ban_ngoai_da() {
        return noi_ban_ngoai_da;
    }

    public void setNoi_ban_ngoai_da(boolean noi_ban_ngoai_da) {
        this.noi_ban_ngoai_da = noi_ban_ngoai_da;
    }

    public boolean isPhoi_nhiem_1() {
        return phoi_nhiem_1;
    }

    public void setPhoi_nhiem_1(boolean phoi_nhiem_1) {
        this.phoi_nhiem_1 = phoi_nhiem_1;
    }

    public boolean isPhoi_nhiem_2() {
        return phoi_nhiem_2;
    }

    public void setPhoi_nhiem_2(boolean phoi_nhiem_2) {
        this.phoi_nhiem_2 = phoi_nhiem_2;
    }

    @Override
    public String toString() {
        return "Health{" +
                "fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", travelInfo='" + travelInfo + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", visitedPlaces='" + visitedPlaces + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sot=" + sot +
                ", ho=" + ho +
                ", kho_tho=" + kho_tho +
                ", dau_hong=" + dau_hong +
                ", non_buon_non=" + non_buon_non +
                ", tieu_chay=" + tieu_chay +
                ", xuat_huyet_ngoai_da=" + xuat_huyet_ngoai_da +
                ", noi_ban_ngoai_da=" + noi_ban_ngoai_da +
                ", phoi_nhiem_1=" + phoi_nhiem_1 +
                ", phoi_nhiem_2=" + phoi_nhiem_2 +
                '}';
    }
}

