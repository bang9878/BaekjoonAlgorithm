#include "iostream"
using namespace std;
int main()
{
  int T;
  int HP, MP, attack, defense;
  int HP1, MP1, attack1, defense1;
  int t_HP, t_MP, t_attack, t_defense;
  int power;
  cin>>T;
  for(int i =0; i<T; i++){
    cin>>HP>>MP>>attack>>defense>>HP1>>MP1>>attack1>>defense1;
    t_HP = HP + HP1;
    t_MP = MP + MP1;
    t_attack = attack + attack1;
    t_defense = defense + defense1;
    if(t_HP<1)t_HP=1;
    if(t_MP<1)t_MP=1;
    if(t_attack<0)t_attack=0;
    power = 1*t_HP + 5*t_MP + 2*t_attack + 2*t_defense;
    cout<<power<<'\n'; 
  }
}