package com.mukila;

enum Gender
{
    M,
    F
}

public class Member {
    private String name;
    private int age;
    private Gender gender;

    public Member(String name, int age, String gender)
    {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAge(int age)
    {
        if (age > 0)
        {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public int getAge()
    {
        return this.age;
    }

    public void setGender(String gender)
    {
        if(gender.equalsIgnoreCase("male"))
        {
            this.gender = Gender.M;
        } else if (gender.equalsIgnoreCase("female"))
        {
            this.gender = Gender.F;
        } else {
            System.err.print("Invalid Gender");
            System.exit(1);
        }
    }

    public String getGender()
    {
        String result = null;
        if(this.gender == Gender.M)
        {
            result = "male";
        } else if (this.gender == Gender.F)
        {
            result = "female";
        }
        return result;
    }
}
