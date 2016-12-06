package com.example.theo.myapplication2;


public class Child {
      //private variables
        private int _id;
        private String _name;
        private String _date_of_birth;
        private String _type;

        // Empty constructor
        public Child(){

        }
        // constructor
        public Child(int id, String name, String _date_of_birth,String _type) {
            this._id = id;
            this._name = name;
            this._date_of_birth = _date_of_birth;
            this._type= _type;
        }

        // constructor
        public Child(String name, String _date_of_birth, String _type){
            this._name = name;
            this._date_of_birth = _date_of_birth;
            this._type= _type;
        }
        // getting ID
        public int getID(){
            return this._id;
        }

        // setting id
        public void setID(int id){
            this._id = id;
        }

        // getting name
        public String getName(){
            return this._name;
        }

        // setting name
        public void setName(String name){
            this._name = name;
        }

        // getting phone number
        public String getDateOfBirth(){
            return this._date_of_birth;
        }

        // setting phone number
        public void setDateOfBirth(String dateOfBirth){
            this._date_of_birth = dateOfBirth;
        }

        public String getType(){
            return this._type;
        }

        // setting phone number
        public void setType(String type){
            this._type = type;
        }
}
