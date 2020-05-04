package com.justicekn.webgame.Bean.GameMain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BattleInf
{
    private boolean monsterSide = false;
    private boolean userSide = false;
    private String battleInf;
    private String skillInf;
    private boolean useSkill = false;
    private boolean criticalHit = false;
    private boolean antiInjury = false;
    private boolean restoreLife = false;

    public boolean isAntiInjury()
    {
        return antiInjury;
    }

    public void setAntiInjury(boolean antiInjury)
    {
        this.antiInjury = antiInjury;
    }

    public boolean isRestoreLife()
    {
        return restoreLife;
    }

    public void setRestoreLife(boolean restoreLife)
    {
        this.restoreLife = restoreLife;
    }

    public String getSkillInf()
    {
        return skillInf;
    }

    public void setSkillInf(String skillInf)
    {
        this.skillInf = skillInf;
    }

    public boolean isUseSkill()
    {
        return useSkill;
    }

    public void setUseSkill(boolean useSkill)
    {
        this.useSkill = useSkill;
    }

    public boolean isCriticalHit()
    {
        return criticalHit;
    }

    public void setCriticalHit(boolean criticalHit)
    {
        this.criticalHit = criticalHit;
    }

    public boolean isMonsterSide()
    {
        return monsterSide;
    }

    public void setMonsterSide(boolean monsterSide)
    {
        this.monsterSide = monsterSide;
    }

    public boolean isUserSide()
    {
        return userSide;
    }

    public void setUserSide(boolean userSide)
    {
        this.userSide = userSide;
    }

    public String getBattleInf()
    {
        return battleInf;
    }

    public void setBattleInf(String battleInf)
    {
        this.battleInf = battleInf;
    }
}
