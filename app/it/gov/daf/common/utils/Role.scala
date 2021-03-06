package it.gov.daf.common.utils

sealed abstract class Role(name : String){
  override def toString = name
}

case object SysAdmin extends Role("daf_sys_admin")
case object Admin extends Role("daf_adm_")
case object Editor extends Role("daf_edt_")
case object Viewer extends Role("daf_vwr_")

object Role{

  val rolesPrefixs:Seq[String] = Seq(SysAdmin.toString, Admin.toString, Editor.toString, Viewer.toString)

  def pickRole( lista:Seq[String],group:String ):Option[Role] = {

    val appo = lista.filter(_.endsWith(group))

    if( appo.contains(Admin.toString+group) )
      Some(Admin)
    else if( appo.contains(Editor.toString+group) )
      Some(Editor)
    else if( appo.contains(Viewer.toString+group) )
      Some(Viewer)
    else
      None
  }
}




