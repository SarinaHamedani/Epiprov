# PATINA / Epiprov — Installation

PATINA is distributed as an **Eclipse p2 update site (ZIP)**. Install it into your Eclipse Modeling IDE to enable the DSL editors and toolbar actions.

## Prerequisites

* **Eclipse IDE for Modeling** (recent SimRel recommended)
* **Java 21** JRE/JDK (e.g., Temurin/JustJ)
* **Xtext** installed in Eclipse

  * Update site: `https://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/`
  * In Eclipse: **Help → Install New Software… → Add… → Location =** the URL above → install **Xtext SDK** → restart.

---

## Install from the Release ZIP (offline)

1. Download the ZIP from GitHub Releases:
   **Releases →** [https://github.com/SarinaHamedani/Epiprov/releases/tag/v1.0.0](https://github.com/SarinaHamedani/Epiprov/releases/tag/v1.0.0)
   Download **`patina-update-site-v1.0.0.zip`**.
2. In Eclipse: **Help → Install New Software…**
3. Click **Add…** → **Archive…** → select `patina-update-site-v1.0.0.zip` → give it a name (e.g., `PATINA`).
4. **Uncheck** *Group items by category*.
5. Select the PATINA features → **Next** → accept licenses.
6. If prompted about unsigned content, choose **Trust** / **Install anyway**.
7. **Restart** Eclipse.

### Verify installation

* You should see **two new icons** in the **toolbar**:

  * **Decomposer Launch** (opens the Decomposer wizard)
  * **Trust Evaluation Launch** (opens the EvaluationProcess wizard)
* In the Project Explorer (right-click):

  * On a `*.provn` file → **Cluster Model Parameters**
  * On a `*.trustdsl` file → **Aggregate Opinions**

---

## Updating to a new version

1. Download the newer `patina-update-site-vX.Y.Z.zip`.
2. **Help → Install New Software… → Add… → Archive…** and select the new ZIP (or **Edit…** the existing site and swap the ZIP).
3. Proceed with install → restart Eclipse.

---

## Uninstall

**Help → About Eclipse → Installation Details → Installed Software** → select PATINA entries → **Uninstall…** → restart.

---

## Troubleshooting

* **Items don’t show in Install dialog** → ensure *Group items by category* is **unchecked**.
* **Missing Xtext bundles** → install **Xtext SDK** from the update site above, restart, then try again.
* **No toolbar icons after install** → check **Window → Perspective → Customize Perspective… → Tool Bar Visibility** and confirm the contributed toolbar is visible; also verify the features under **About → Installation Details**.
* **Apple Silicon (macOS)** → use an **ARM** Eclipse build and **ARM** JDK (avoid Rosetta). In **Help → About → Installation Details → Configuration**, verify `osgi.arch=aarch64`.

---

## License / Citation

*Add your license text and citation instructions here.*
