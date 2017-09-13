//
//  RemOptions1Controller.swift
//  envprojnew
//
//  Created by Frances Lin on 8/15/17.
//  Copyright © 2017 Frances Lin. All rights reserved.
//

import Foundation
import UIKit

class RemOptions1Controller: UIViewController {
    
    @IBOutlet weak var length: UITextField!
    @IBOutlet weak var width: UITextField!
    @IBOutlet weak var height: UITextField!
    @IBAction func goback(_ sender: Any) {
        self.performSegue(withIdentifier: "backPol", sender: self)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        print(LandOptionsController.Choice.Choice)
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func toOptions(_ sender: Any) {
        Data.size = Double(length.text!)! * Double(width.text!)! * Double(height.text!)!
        if SiteTypeViewController.Properties.Land == true {
            let onelow = (100*Data.size*0.001)
            let onehigh = (800*Data.size*0.001)
            let oneavg = (300*Data.size*0.001)
            let twolow = (150*Data.size*0.001)
            let twohigh = (400*Data.size*0.001)
            let twoavg = (200*Data.size*0.001)
            let threelow = (400*Data.size*0.001)
            let threehigh = (2000*Data.size*0.001)
            let threeavg = (1000*Data.size*0.001)
            let fourlow = (200*Data.size*0.001)
            let fourhigh = (600*Data.size*0.001)
            let fouravg = (300*Data.size*0.001)
            let fivelow = (150*Data.size*0.001)
            let fivehigh = (600*Data.size*0.001)
            let fiveavg = (250*Data.size*0.001)
            let sixlow = (200*Data.size*0.001)
            let sixhigh = (1000*Data.size*0.001)
            let sixavg = (300*Data.size*0.001)
            let sevlow = (450*Data.size*0.001)
            let sevhigh = (800*Data.size*0.001)
            let sevavg = (600*Data.size*0.001)
            let eightlow = (300*Data.size*0.001)
            let eighthigh = (3000*Data.size*0.001)
            let eightavg = (1500*Data.size*0.001)
            let ninelow = (2399*Data.size*0.001)
            let ninehigh = (11504*Data.size*0.001)
            let nineavg = (6951*Data.size*0.001)
            let tenlow = (350*Data.size*0.001)
            let tenhigh = (1500*Data.size*0.001)
            let tenavg = (650*Data.size*0.001)
            let elelow = (500*Data.size*0.001)
            let elehigh = (5000*Data.size*0.001)
            let eleavg = (2000*Data.size*0.001)
            let twelow = (150*Data.size*0.001)
            let twehigh = (500*Data.size*0.001)
            let tweavg = (250*Data.size*0.001)
            let thilow = (100*Data.size*0.001)
            let thihigh = (800*Data.size*0.001)
            let thiavg = (300*Data.size*0.001)
            let furlow = (300*Data.size*0.001)
            let furhigh = (1500*Data.size*0.001)
            let furavg = (600*Data.size*0.001)
            let fiflow = (600*Data.size*0.001)
            let fifhigh = (6000*Data.size*0.001)
            let fifavg = (3300*Data.size*0.001)
            let sixtlow = (200*Data.size*0.001)
            let sixthigh = (800*Data.size*0.001)
            let sixtavg = (550*Data.size*0.001)
            let sevtlow = (50*Data.size*0.001)
            let sevthigh = (500*Data.size*0.001)
            let sevtavg = (150*Data.size*0.001)
            Data.nums = [100, 800, 300, onelow, onehigh, oneavg, 0, 0, 150, 400, 200, twolow, twohigh, twoavg,
            twolow*0.1, twohigh*0.1, twoavg*0.1, twolow*0.9, twohigh*0.9, twoavg*0.9, (Double(length.text!)! * Double(width.text!)!), (Double(length.text!)! * Double(width.text!)! / 30), (Double(length.text!)! * Double(width.text!)! / 90), 400, 2000, 1000, threelow, threehigh, threeavg, 0, 0, 200, 600, 300, fourlow, fourhigh, fouravg, 0, 0, 150, 600, 250, fivelow, fivehigh, fiveavg, 0, 0, 200, 1000, 300, sixlow, sixhigh, sixavg, 0, 0, 450, 800, 600, sevlow, sevhigh, sevavg, 0, 0, 300, 3000, 1500, eightlow, eighthigh, eightavg, 0, 0, 2399, 11504, 6951, ninelow, ninehigh, nineavg, 0, 0, 350, 1500, 650, tenlow, tenhigh, tenavg, 0, 0, 500, 5000, 2000, elelow, elehigh, eleavg, 0, 0, 150, 500, 250, twelow, twehigh, tweavg, 0, 0, 100, 800, 300, thilow, thihigh, thiavg, 0, 0, 300, 1500, 600, furlow, furhigh, furavg, 0, 0, 600, 6000, 3300, fiflow, fifhigh, fifavg, 0, 0, 200, 800, 550, sixtlow, sixthigh, sixtavg, 0, 0, 0, 0, 50, 500, 150, sevtlow, sevthigh, sevtavg, 0, 0]
        } else if SiteTypeViewController.Properties.Land == false {
            let onelow = (157*Data.size*0.001)
            let onehigh = (557*Data.size*0.001)
            let oneavg = (357*Data.size*0.001)
            let twolow = (100*Data.size*0.001)
            let twohigh = (800*Data.size*0.001)
            let twoavg = (600*Data.size*0.001)
            let threelow = (100*Data.size*0.001)
            let threehigh = (3000*Data.size*0.001)
            let threeavg = (600*Data.size*0.001)
            let fourlow = (50*Data.size*0.001)
            let fourhigh = (600*Data.size*0.001)
            let fouravg = (200*Data.size*0.001)
            let fivlow = (150*Data.size*0.001)
            let fivhigh = (350*Data.size*0.001)
            let fivavg = (200*Data.size*0.001)
            Data.nums = [157, 557, 357, onelow, onehigh, oneavg, 0, 0, 100, 800, 600, twolow, twohigh, twoavg, 0, 0, 100, 3000, 600, threelow, threehigh, threeavg, 0, 0, 50, 600, 200, fourlow, fourhigh, fouravg, 0, 0, 0, 0, 150, 350, 200, fivlow, fivhigh, fivavg, 0, 0, 200000, 1000000, 600000, 200, 1000, 600, 0, 0]
        }
        self.performSegue(withIdentifier: "toTable", sender: self)
    }
    
    struct Data {
        static var size = Double()
        static var nums = [Double]()
    }
    
    
}

