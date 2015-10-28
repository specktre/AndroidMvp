package com.specktre.domain.usercoderepos;

public class UserCodingLifeViewModel {

    private boolean isJavaProgrammer;
    private boolean isStar;
    private String nameOfMostRatedRepo;

    public UserCodingLifeViewModel(boolean isJavaProgrammer, boolean isStar, String nameOfMostRatedRepo) {
        this.isJavaProgrammer = isJavaProgrammer;
        this.isStar = isStar;
        this.nameOfMostRatedRepo = nameOfMostRatedRepo;
    }

    public String getNameOfMostRatedRepo() {
        return nameOfMostRatedRepo;
    }

    public void setNameOfMostRatedRepo(String nameOfMostRatedRepo) {
        this.nameOfMostRatedRepo = nameOfMostRatedRepo;
    }

    public boolean isStar() {
        return isStar;
    }

    public void setIsStar(boolean isStar) {
        this.isStar = isStar;
    }

    public boolean isJavaProgrammer() {
        return isJavaProgrammer;
    }
}
