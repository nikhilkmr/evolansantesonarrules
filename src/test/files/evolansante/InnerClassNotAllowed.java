package com.sopasteria.sonar.evolansante.java.rules;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.sopra.mutuelles.businessmodel.BPDI;
import com.sopra.mutuelles.businessmodel.BPDO;
import com.sopra.mutuelles.businessmodel.impl.BPDOImpl;
import com.sopra.mutuelles.businessmodel.impl.com.ISDA;
import com.sopra.mutuelles.businessmodel.impl.com.TechElementCom;
import com.sopra.mutuelles.rc.ad.business.Modulation;
import com.sopra.mutuelles.rc.business.technical.TechMAJ;
import com.sopra.mutuelles.rc.business.technical.TechRecherche;
import com.sopra.mutuelles.rc.co.business.ConstantesAdministrativesCO;
import com.sopra.mutuelles.rc.co.modulations.beans.BeanModulation;
import com.sopra.mutuelles.utils.object.Conversion;
import com.sopra.mutuelles.utils.pagination.DataPagination;
import com.sopra.mutuelles.utils.string.TestString;

public class InnerClassNotAllowed
{

    public void method()
    {

        Runnable annonymousClassInMethod = new Runnable() {

            @Override
            public void run()
            {
                // TODO Auto-generated method stub

            }
        };

    }

    protected BPDO process(BPDI in) throws Exception
    {
        BPDOImpl out = new BPDOImpl();
        final ISDA com = (ISDA) in.getCom(TechElementCom.__NOM_COM_TP);
        TechRecherche techRecherche = (TechRecherche) in.get(ConstantesAdministrativesCO.TECHRECHERCHE);
        TechMAJ techMaj = (TechMAJ) in.get(ConstantesAdministrativesCO.TECHMAJ);
        String type2 = (String) in.get("type2");
        BeanModulation origBeanModulation = (BeanModulation) in.get("origBeanModulation");
        if (techRecherche != null)
        {
            Modulation criModulation = new Modulation();
            Conversion.copy(origBeanModulation, criModulation, false);
            int nbMax = ((DataPagination) in.get("pagination")).getLigneDBMax();
            // Set disabledFieldsSet = (Set) in.get("disabledFieldsSet");
            // debut avoid anonymous class use.
            HashMap paginationmap = new HashMap(((DataPagination) in.get("pagination")).getClePagination()) {
                private static final long serialVersionUID = -354356115837614052L;

                public Object get(Object key)
                {
                    Object value = null;
                    if (key instanceof String)
                    {
                        String keyStr = (String) key;
                        value = super.get(keyStr.toLowerCase());
                    }
                    if (value == null)
                    {
                        value = super.get(key);
                    }
                    return value;
                }
            };
            // HashMap paginationmap = ((DataPagination) in.get("pagination")).getClePagination();
            // fin avoid anonymous class use.
            Modulation pgModulation = null;
            if (!TestString.isBlankOrNull((String) paginationmap.get("cdsgrp")))
            {
                pgModulation = new Modulation(paginationmap);
            }
            List list = null;
            if (TestString.isBlank(type2))
            {
                // MUCMCOHD
                list = Modulation.getHistoryListFromMucmcohh(com, criModulation, pgModulation, nbMax);
            }
            else
            {
                // MUCMDEHD
                list = Modulation.getHistoryListFromMucmdehh(com, criModulation, pgModulation, nbMax);
            }
            out.set(ConstantesAdministrativesCO.PAGINATION_LISTE, list);
        }
        if (techMaj != null)
        {
            BeanModulation beanModulation = (BeanModulation) in.get("beanModulation");
            Modulation modulation = new Modulation();
            Conversion.copy(beanModulation, modulation, false);

            if (modulation.getGroupm() == null)
            {
                modulation.setGroupm(BigDecimal.ZERO);
            }

            if (modulation.getSectim() == null)
            {
                modulation.setSectim(BigDecimal.ZERO);
            }

            boolean isMucmcohd = false;
            if (TestString.isBlank(type2))
            {
                isMucmcohd = true;
            }
            if (techMaj.getCdmaj().equals(ConstantesAdministrativesCO.MODE_CREATION))
            {
                if (isMucmcohd)
                {
                    modulation.creerModulationInMucmcohd(com, techMaj.getCdacce());
                }
                else
                {
                    modulation.creerModulationInMucmdehd(com, techMaj.getCdacce());
                }
            }
            else if (techMaj.getCdmaj().equals(ConstantesAdministrativesCO.MODE_MODIFICATION))
            {
                Modulation origModulation = new Modulation();
                Conversion.copy(origBeanModulation, origModulation, false);
                if (origModulation.getGroupm() == null)
                {
                    origModulation.setGroupm(BigDecimal.ZERO);
                }

                if (origModulation.getSectim() == null)
                {
                    origModulation.setSectim(BigDecimal.ZERO);
                }

                if (isMucmcohd)
                {
                    origModulation.creerHistoryInMucmcohh(com, techMaj.getCdmaj(), techMaj.getCdacce());
                    modulation.modifyMucmcohd(com, techMaj.getCdacce(), origModulation);
                }
                else
                {
                    origModulation.creerHistoryInMucmdehh(com, techMaj.getCdmaj(), techMaj.getCdacce());
                    modulation.modifyMucmdehd(com, techMaj.getCdacce(), origModulation);
                }

            }
            else if (techMaj.getCdmaj().equals(ConstantesAdministrativesCO.MODE_SUPPRIMER))
            {
                Modulation origModulation = new Modulation();
                Conversion.copy(origBeanModulation, origModulation, false);
                if (origModulation.getGroupm() == null)
                {
                    origModulation.setGroupm(BigDecimal.ZERO);
                }

                if (origModulation.getSectim() == null)
                {
                    origModulation.setSectim(BigDecimal.ZERO);
                }
                if (isMucmcohd)
                {
                    origModulation.creerHistoryInMucmcohh(com, techMaj.getCdmaj(), techMaj.getCdacce());
                    modulation.deleteFromMucmcohd(com);
                }
                else
                {
                    origModulation.creerHistoryInMucmdehh(com, techMaj.getCdmaj(), techMaj.getCdacce());
                    modulation.deleteFromMucmdehd(com);
                }

            }
        }
        return out;
    }

}