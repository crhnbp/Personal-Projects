//
//  LandOptionsController.swift
//  envprojnew
//
//  Created by Frances Lin on 8/13/17.
//  Copyright © 2017 Frances Lin. All rights reserved.
//

import Foundation
import UIKit

class LandOptionsController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    @IBOutlet weak var picker: UIPickerView!
    @IBOutlet weak var picker2: UIPickerView!
    @IBOutlet weak var picker3: UIPickerView!
    @IBOutlet weak var picker4: UIPickerView!
    @IBOutlet weak var picker5: UIPickerView!
    @IBOutlet weak var picker6: UIPickerView!
    
    @IBAction func prevView(_ sender: Any) {
        self.performSegue(withIdentifier: "toBack", sender: self)
    }
    @IBAction func nextView(_ sender: Any) {
        self.performSegue(withIdentifier: "toRem", sender: self)
    }
    
    var pickerData: [String] = [String]()
    var picker2Data: [String] = [String]()
    var picker3Data: [String] = [String]()
    var picker4Data: [String] = [String]()
    var picker5Data: [String] = [String]()
    var picker6Data: [String] = [String]()
    override func viewDidLoad() {
        super.viewDidLoad()
        self.picker.delegate = self
        self.picker.dataSource = self
        self.picker2.delegate = self
        self.picker2.dataSource = self
        self.picker3.delegate = self
        self.picker3.dataSource = self
        self.picker4.delegate = self
        self.picker4.dataSource = self
        self.picker5.delegate = self
        self.picker5.dataSource = self
        self.picker6.delegate = self
        self.picker6.dataSource = self
        
        picker.tag = 0
        picker2.tag = 1
        picker3.tag = 2
        picker4.tag = 3
        picker5.tag = 4
        picker6.tag = 5
        
        pickerData = ["Nonhalogenated VOCs", "1-butanol", "4-Methyl-2-pentanone", "Acetone", "Acrolein", "Acrylonitrile", "Aminobenzene", "Carbon disulfide", "Cyclohexanone", "Ethanol", "Ethyl acetate", "Ethyl ether", "Isobutanol", "Methanol", "Methyl ethyl ketone (MEK)", "Methyl isobutyl ketone", "n-Butyl alcohol", "Styrene", "Tetrahydrofuran", "Vinyl acetate"]
        picker2Data = ["Halogenated VOCs", "1,1,1,2-Tetrachloroethane", "1,1,1-Trichloroethane", "1,1,2,2-Tetrachloroethane", "1,1,2-Trichloroethane", "1,1-Dichloroethane", "1,1-Dichloroethylene", "1,2,2-Trifluoroethane (Freon 113)", "1,2-Dichloroethane", "1,2-Dichloropropane", "1,2-Trans-dichloroethylene", "1,3-cis-dichloro-1-propene", "1,3-trans-dichloropropene", "1-chloro-2-propene", "2-butylene dichloride", "Acetylene tetrachloride", "Bromodichloromethane", "Bromoform", "Bromomethane", "Carbon tetrachloride", "Chlorodibromomethane", "Chloroethane", "Chloroform", "Chloromethane", "Chloropropane", "Cis-1,2-dichloroethylene", "Cis-1,3-dichloropropene", "Dibromochloropropane", "Dibromomethane", "Dichlorobromomethane", "Dichloromethane", "Ethylene dibromide", "Fluorotrichloromethane (Freon 11)", "Glycerol trichlorohydrin", "Hexachlorobutadiene", "Hexachlorocyclopentadiene", "Hexachloroethane", "Methylene chloride", "Neoprene", "Pentachloroethane", "Perchloroethylene", "Propylene dichloride", "Trichlorotrifluoroethane", "Monochlorobenzene", "Tetrachloroethylene (Perchloroethylene) (PCE)", "Trichloroethylene (TCE)", "Vinyl chloride", "Vinyl trichloride", "Vinylidene chloride"]
        picker3Data = ["Nonhalogenated SVOCs",
            "1,2-benzacenaphthene",
            "1,2-Diphenylhydrazine",
            "1-aminonaphathalene",
            "2,3-phenylenepyrene",
            "2,4,-Dinitrophenol",
            "2-aminonaphthalene",
            "2-Methylnaphthalene",
            "2-Nitroaniline",
            "2-Nitrophenol",
            "3-Nitroaniline",
            "4,6-Dinitro-2-methylphenol",
            "4-Nitroaniline",
            "4-Nitrophenol",
            "Acenaphthene",
            "Acenaphthylene",
            "Allyldioxybenzene methylene ether",
            "Anthracene",
            "Benzidine",
            "Benzo(a)anthracene",
            "Benzo(a)pyrene",
            "Benzo(b)fluoranthene",
            "Benzo(k)fluoranthene",
            "Benzoic Acid",
            "Benzyl alcohol",
            "Bis(2-ethylhexyl)phthalate",
            "Butyl benzyl phthalate",
            "Chrysene",
            "Dibenzofuran",
            "Diethyl phthalate",
            "Dimethyl phthalate",
            "Di-n-butyl phthalate",
            "Di-n-octyl phthalate",
            "Diphenylenemethane",
            "Ethion",
            "Ethyl parathion",
            "Fluorene",
            "Indeno(1,2,3-cd)pyrene",
            "Isophorone",
            "Malathion",
            "Methylparathion",
            "Naphthalene",
            "n-Nitrosodimethylamine",
            "n-Nitrosodi-n-propylamine",
            "n-Nitrosodiphenylamine",
            "Parathion",
            "Phenanthrene",
            "Phenyl naphthalene",
            "Pyrene",
            "tetraphene"
        ]
        picker4Data = ["Halogenated SVOCs", "1,2,4-Trichlorobenzene", "1,2-Bis(2-chloroethoxy) ethane", "1,2-Dichlorobenzene", "1,3-Dichlorobenzene",
                       "1,4-Dichlorobenzene", "2,4,5-Trichlorophenol", "2,4,6-Trichlorophenol", "2,4-Dichlorophenol", "2-Chloronaphthalene",
                       "2-Chlorophenol", "3,3-Dichlorobenzidine", "4-Bromophenyl phenyl ether", "4-Chloroaniline", "4-Chlorophenyl phenylether", "Bis(2-chloroethoxy) ether", "Bis(2-chloroethoxy) methane", "Bis(2-chloroethoxy) phthalate",
            "Bis(2-chloroethyl) ether", "Bis(2-chloroisopropyl) ether", "Chlordane", "Chlorobenzene", "Chlorobenzilate",
                                        "Chlorphenothane", "Hexachlorobenzene", "Hexachlorobenzene", "Hexachlorobutadiene", "Hexachlorocyclopentadiene",
                                        "o-dichlorobenzene", "p-Chloro-m-cresol", "p-dichlorobenzene", "Pentachlorobenzene", "Pentachlorophenol (PCP)",
                                        "Polychlorinated biphenyls (PCBs)", "Quintozene", "Tetrachlorophenol", "Unsym-trichlorobenzene", "Aldrin", "BHC-alpha",
                                        "BHC-beta", "BHC-delta", "BHC-gamma", "Chlordane", "4,4'-DDD", "4,4'-DDE", "4,4'-DDT", "Dieldrin", "Endosulfan I",
                                        "Endosulfan II", "Endosulfan sulfate", "Endrin", "Endrin aldehyde", "Ethion", "Ethyl parathion", "Heptachlor",
                                        "Heptachlor epoxide", "Malathion", "Methylparathion", "Parathion", "Toxaphene"]
        picker5Data = ["Fuels", "1,2,3,4-Tetramethylbenzene", "1,2,4,5-Tetramethylbenzene", "1,2,4-Trimethyl- 5-ethylbenzene", "1,2,4-Trimethylbenzene", "1,3,5-Trimethylbenzene", "1-Pentene", "2,2,4-Trimethylheptane", "2,2,4-Trimethylpentane", "2,2-Dimethylheptane", "2,2-Dimethylhexane", "2,2-Dimethylpentane", "2,3,4-Trimethylheptane", "2,3,4-Trimethylhexane", "2,3,4-Trimethylpentane", "2,3-Dimethylbutane", "2,3-Dimethylpentane", "2,4,4-Trimethylhexane", "2,4-Dimethylphenol", "2-Methyl-1,3-butadiene", "2-Methyl-2-butene", "2-Methyl-butene", "2-Methylheptane", "2-Methylnaphthalene", "2-Methylpentane", "2-Methylphenol", "3,3,5-Trimethylheptane", "3,3-Dimethyl-1-butene", "3-Ethylpentane", "3-Methyl-1,2-butadiene", "3-Methyl-1-butene", "3-Methyl-1-pentene", "3-Methylheptane", "3-Methylhexane", "3-Methylpentane", "4-Methylphenol", "Acenaphthene", "Anthracene", "Benz(a)anthracene", "Benzene", "Benzo(a)pyrene", "Benzo(b)fluoranthene", "Benzo(g,h,i)perylene", "Benzo(k)fluoranthene", "Chrysene", "Cis-2-butene", "Creosols", "Cyclohexane", "Cyclopentane", "Dibenzo(a,h)anthracene", "Dimethylethylbenzene", "Ethylbenzene", "Fluoranthene", "Fluorene", "Ideno(1,2,3-c,d)pyrene", "Isobutane", "Isopentane", "Methylcyclohexane", "Methylcyclopentane", "Methylnaphthalene", "Methylpropylbenzene", "m-Xylene", "Naphthalene", "n-Butane", "n-Decane", "n-Dodecane", "n-Heptane", "n-Hexane", "n-Hexylbenzene", "n-Nonane", "n-Octane", "n-Pentane", "n-Propylbenzene", "n-Undecane", "o-Xylene", "Phenanthrene", "Phenol", "Propane", "p-Xylene", "Pyrene", "Pyridine", "Toluene", "Trans-2-butene", "Trans-2-pentene", "Vinylbenzene"]
        picker6Data = ["Inorganics", "Alumina", "Aluminum", "Antimony", "Arsenic", "Barium", "Beryllium", "Bismuth", "Boron", "Cadmium", "Calcium", "Chromium", "Cobalt", "Copper", "Iron", "Lead", "Magnesium", "Manganese", "Mercury", "Metallic cyanides", "Molybdenum", "Nickel", "Potassium", "Selenium", "Silver", "Sodium", "Thallium", "Tin", "Titanium", "Vanadium", "Zinc", "Zirconium"]
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // The number of columns of data
    func numberOfComponents(in: UIPickerView) -> Int {
        return 1
    }
    
    // The number of rows of data
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent: Int) -> Int {
        if pickerView.tag == 0 {
        return pickerData.count
        } else if pickerView.tag == 1 {
            return picker2Data.count
        } else if pickerView.tag == 2 {
            return picker3Data.count
        } else if pickerView.tag == 3 {
            return picker4Data.count
        } else if pickerView.tag == 4 {
            return picker5Data.count
        } else if pickerView.tag == 5 {
            return picker6Data.count
        }
        return 1
    }
    
    // The data to return for the row and component (column) that's being passed in
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if pickerView.tag == 0 {
            return pickerData[row]
        } else if pickerView.tag == 1 {
            return picker2Data[row]
        } else if pickerView.tag == 2 {
            return picker3Data[row]
        } else if pickerView.tag == 3 {
            return picker4Data[row]
        } else if pickerView.tag == 4 {
            return picker5Data[row]
        } else if pickerView.tag == 5 {
            return picker6Data[row]
        }
        return ""
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if pickerView.tag == 0 && row != 0 {
        Choice.Choice = pickerData[row]
        Choice.Category = "0"
        } else if pickerView.tag == 1 && row != 0 {
            Choice.Choice = picker2Data[row]
            Choice.Category = "1"
        } else if pickerView.tag == 2 && row != 0 {
            Choice.Choice = picker3Data[row]
            Choice.Category = "2"
        } else if pickerView.tag == 3 && row != 0 {
            Choice.Choice = picker4Data[row]
            Choice.Category = "3"
        } else if pickerView.tag == 4 && row != 0 {
            Choice.Choice = picker5Data[row]
            Choice.Category = "4"
        } else if pickerView.tag == 5 && row != 0 {
            Choice.Choice = picker6Data[row]
            Choice.Category = "5"
        }
    }
    
    struct Choice{
        static var Choice = String()
        static var Category = String()
    }
    
    
}
